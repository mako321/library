package com.github.mako321.Services;

import com.github.mako321.Models.CallSlip;
import com.github.mako321.Models.Reader;
import com.github.mako321.Models.Volume;
import com.github.mako321.Repositories.CallSlipInMemoryRepository;
import com.github.mako321.Repositories.Contracts.CallSlipRepository;

import java.util.List;

public class CallSlipService {
    private final ReaderService readerService;
    private final VolumeService volumeService;
    private final CallSlipRepository callSlipRepository;

    public CallSlipService() {
        this.readerService = new ReaderService();
        this.volumeService = new VolumeService();
        this.callSlipRepository = new CallSlipInMemoryRepository();
    }

    public void borrow() {
        // wczytanie woluminu
        var volumeOptional = this.volumeService.enterVolume();
        if (volumeOptional.isEmpty()) {
            return;
        }

        if (isVolumeBorrowed(volumeOptional.get().getId())) {
            System.out.println("Wolumin został wypożyczony, nie jest dostępny!");
            return;
        }

        // wczytanie czytelnika
        var readerOptional = this.readerService.enterReader();
        if (readerOptional.isEmpty()) {
            return;
        }

        if (this.readerService.isMaxBorrowLimitReached(readerOptional.get())) {
            System.out.println("Przekroczono liczbę wypożyczeń!");
            return;
        }

        saveBorrow(volumeOptional.get(), readerOptional.get());
    }

    public void saveBorrow(Volume volume, Reader reader) {
        var callSlip = new CallSlip(volume, reader);
        reader.addCallSlip(callSlip);
        this.callSlipRepository.save(callSlip);
        System.out.println("Rewers został zapisany -> " + callSlip + "\n");
    }

    public boolean isVolumeBorrowed(int volumeId) {
        return this.callSlipRepository.findByVolumeId(volumeId).isPresent();
    }

    public void printAll() {
        var all = getAll();

        if (all.isEmpty()) {
            System.out.println("Brak!");
        }

        getAll().forEach(System.out::println);
    }

    public List<CallSlip> getAll() {
        return this.callSlipRepository.findAll();
    }
}

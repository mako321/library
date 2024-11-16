package com.github.mako321.Repositories;

import com.github.mako321.Models.CallSlip;
import com.github.mako321.Repositories.Contracts.CallSlipRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CallSlipInMemoryRepository implements CallSlipRepository {

    private static final List<CallSlip> callSlips = new LinkedList<>();

    public CallSlip save(CallSlip callSlip) {
        callSlips.add(callSlip);

        return callSlip;
    }

    public List<CallSlip> findAll() {
        return callSlips;
    }

    public Optional<CallSlip> findByVolumeId(Integer volumeId) {
        return callSlips                                                         // źródło danych
                .stream()                                                        // tworzenie strumienia
                .filter(callSlip -> callSlip.getVolume().getId() == volumeId)    // metoda pośrednia; metoda filter pobiera ze strumienia elementy zgodne z predykatem
                .findFirst();                                                    // metoda końcowa; metoda findFirst zwraca pierwszy element strumienia opakowany w instancję typu Optional<T>
    }
}

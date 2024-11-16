package com.github.mako321.Repositories.Contracts;

import com.github.mako321.Models.CallSlip;

import java.util.List;
import java.util.Optional;

public interface CallSlipRepository {
    CallSlip save(CallSlip callSlip);

    List<CallSlip> findAll();

    Optional<CallSlip> findByVolumeId(Integer volumeId);
}

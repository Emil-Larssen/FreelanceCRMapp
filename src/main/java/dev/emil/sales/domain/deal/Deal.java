package dev.emil.sales.domain.deal;

import dev.emil.sales.domain.prospect.Prospect;

import java.util.UUID;

public class Deal {
    private DealState state;
    private UUID prospectId;

    private Deal(DealState state, UUID prospectId) {
        this.state = state;
        this.prospectId = prospectId;
    }

    public static Deal create(Prospect prospect) {
        return new Deal(DealState.DRAFT, prospect.getUUID());
    }

    public DealState getState() {
        return state;
    }

    public UUID getDealProspectId() {
        return prospectId;
    }

}

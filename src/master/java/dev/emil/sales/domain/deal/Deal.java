package dev.emil.sales.domain.deal;

public class Deal {
    private DealState state;

    private Deal(DealState state) {
        this.state = state;
    }

    public static Deal create() {
        return new Deal(DealState.DRAFT);
    }

    public DealState getState() {
        return state;
    }
}

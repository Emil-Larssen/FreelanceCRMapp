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
    public void sendOffer() {
        if (state == DealState.DRAFT) {
            this.state = DealState.OFFERED;
        }
    }
    public void beginNegotiating() {
        if (state == DealState.OFFERED) {
            this.state = DealState.NEGOTIATING;
        }
    }
    public void markDealWon() {
        if (state == DealState.OFFERED || state == DealState.NEGOTIATING) {
            this.state = DealState.WON;
        }
    }
    public void markDealLost() {
        if (state == DealState.OFFERED || state == DealState.NEGOTIATING) {
            this.state = DealState.LOST;
        }
    }
    public void closeDeal() {
        this.state = DealState.CLOSED;
    }


}

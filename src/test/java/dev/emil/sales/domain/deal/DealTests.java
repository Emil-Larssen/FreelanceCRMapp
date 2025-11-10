package dev.emil.sales.domain.deal;
import dev.emil.sales.domain.prospect.Prospect;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DealTests {
    private String testProspectName = "Johnny";

    @Test
    // deal MUST initialize in DRAFT state, and MUST have a prospect.
    void deal_created_with_draft_state_and_prospect() {
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        assertEquals(DealState.DRAFT, deal.getState());
        assertNotNull(deal.getDealProspectId());
    }
    @Test
    // deal can only proceed to OFFERED, if it is in DRAFT state.
    void deal_offered_only_from_draft() {
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        assertEquals(DealState.OFFERED, deal.getState());
    }
    @Test
    // deal can only proceed to NEGOTIATING from OFFERED
    void deal_negotiating_only_from_offered() {
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        deal.beginNegotiating();
        assertEquals(DealState.NEGOTIATING, deal.getState());
    }
    @Test
    // deal WON from OFFERED
    void deal_won_from_offered(){
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        assertEquals(DealState.OFFERED, deal.getState());
        deal.markDealWon();
        assertEquals(DealState.WON, deal.getState());
    }
    @Test
    // deal WON from NEGOTIATING
    void deal_won_from_negotiating(){
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        deal.beginNegotiating();
        assertEquals(DealState.NEGOTIATING, deal.getState());
        deal.markDealWon();
        assertEquals(DealState.WON, deal.getState());
    }
    @Test
    // deal LOST from OFFERED
    void deal_lost_from_offered(){
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        assertEquals(DealState.OFFERED, deal.getState());
        deal.markDealLost();
        assertEquals(DealState.LOST, deal.getState());
    }
    @Test
    // deal LOST from NEGOTIATING
    void deal_lost_from_negotiating(){
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        deal.beginNegotiating();
        assertEquals(DealState.NEGOTIATING, deal.getState());
        deal.markDealLost();
        assertEquals(DealState.LOST, deal.getState());
    }
    @Test
    // deal CLOSED from ANY deal state.
    void deal_closed(){
        Prospect prospect = Prospect.create(testProspectName);
        Deal deal = Deal.create(prospect);
        deal.sendOffer();
        deal.closeDeal();
        assertEquals(DealState.CLOSED, deal.getState());
    }
}

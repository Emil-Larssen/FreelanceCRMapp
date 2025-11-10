package dev.emil.sales.domain.deal;
import dev.emil.sales.domain.prospect.Prospect;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DealTests {

    @Test
    // deal MUST initialize in DRAFT state, and MUST have a prospect.
    void deal_created_with_draft_state_and_prospect() {
        Prospect prospect = Prospect.create("Johnorg");
        Deal deal = Deal.create(prospect);
        assertEquals(DealState.DRAFT, deal.getState());
        assertNotNull(deal.getDealProspectId());

    }

}

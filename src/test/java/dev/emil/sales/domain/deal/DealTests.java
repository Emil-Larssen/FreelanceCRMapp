package dev.emil.sales.domain.deal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DealTests {

    @Test
    void deal_created_with_draft_state() {
        Deal deal = Deal.create();

        assertEquals(DealState.DRAFT, deal.getState());
    }
}

package dev.emil.delivery.domain.task;
import dev.emil.sales.domain.deal.Deal;

import java.util.UUID;

public class Task {
    private TaskState state;
    private UUID taskId;
    private double price;
    private String name;
    private String description;
    private UUID dealId;
}

package manager;

import entity.SubscriptionPlan;
import java.util.*;

/**
 * Quan ly danh sach goi tap (them, xoa, tim kiem...).
 */
public class SubscriptionManager {
    private Map<String, SubscriptionPlan> plans;

    public SubscriptionManager() {
        plans = new HashMap<>();
    }

    public void addPlan(SubscriptionPlan plan) {
        plans.put(plan.getId(), plan);
    }

    public void removePlan(String id) {
        plans.remove(id);
    }

    public SubscriptionPlan getPlanById(String id) {
        return plans.get(id);
    }

    public Collection<SubscriptionPlan> getAllPlans() {
        return plans.values();
    }
}

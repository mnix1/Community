package community.friend;

import javax.validation.constraints.NotNull;

class AddRelationRequestBody {
    @NotNull
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package community.relation;

import javax.validation.constraints.NotNull;

class AddRelationRequestBody {
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

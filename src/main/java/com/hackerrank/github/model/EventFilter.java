package com.hackerrank.github.model;

/***
 * This class is used from EventsController to filter what clientes is the service going to look for
 *
 * @author AB
 */
public class EventFilter {

    private Long actorId;
    private Long repoId;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getRepoId() {
        return repoId;
    }

    public void setRepoId(Long repoId) {
        this.repoId = repoId;
    }
}

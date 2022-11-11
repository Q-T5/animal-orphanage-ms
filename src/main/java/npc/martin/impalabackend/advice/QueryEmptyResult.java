package npc.martin.impalabackend.advice;

/**
 *
 * @author bikathi_martin 
 * @date Aug 1, 2022
 */
public class QueryEmptyResult extends RuntimeException {

    public QueryEmptyResult() {
    }

    public QueryEmptyResult(String message) {
        super(message);
    }
}

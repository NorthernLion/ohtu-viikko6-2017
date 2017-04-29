
package statistics.matcher;

import statistics.Player;

public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new And();
    }
    
    public Matcher build() {
        Matcher made = this.matcher;
        this.matcher = new And();
        return made;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder and(Matcher... matchers) {
        this.matcher = new And(this.matcher, new And(matchers));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not(int value, String category) {
        this.matcher =  new And(this.matcher, new Not(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matches) {
        this.matcher = new And(this.matcher, new Or(matches));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher =  new And(this.matcher, new PlaysIn(team));
        return this;
    }
}


public class SqlQueryLab {
    public static void main(String[] args) {
        SqlQuery query= new SqlQuery.Builder()
                .select("name, registration_num")
                .from("students")
                .where("batch >= 20")
                .build();   
        System.out.println(query.getQuery());
    }
}
class SqlQuery {
    private final String query;

    private SqlQuery(Builder b) {
        this.query= "SELECT "+b.select+" FROM "+b.from + 
                     (b.where != null ? " WHERE "+b.where : "");
    }

    public String getQuery() {
        return query;
    }
    public static class Builder {
        private String select="*";
        private String from;
        private String where;
        public Builder select(String cols) { this.select = cols; return this; }
        public Builder from(String table) { this.from = table; return this; }
        public Builder where(String cond) { this.where = cond; return this; }
        public SqlQuery build() {
            if (this.from== null) {
                throw new IllegalStateException("FROM table is required");
            }
            return new SqlQuery(this);
        }
    }
}

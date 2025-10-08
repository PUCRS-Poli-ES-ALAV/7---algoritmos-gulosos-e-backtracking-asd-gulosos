public class IntervaloObj {
    public int s;
    public int f;
    public int id;
    public IntervaloObj (int s, int f, int id) {
        this.s = s;
        this.f = f;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("\nid: %d | s = %d | f = %d", id, s, f);
    }
}

package entities;

public interface Examinable extends Matchable {
    public String examine();

    public void setDescription(String descr);
}
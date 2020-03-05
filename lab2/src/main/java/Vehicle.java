import java.util.Objects;

public abstract class Vehicle {
    protected String name;
    protected Depot depot;

    abstract String getName();

    abstract void setName(String name);

    abstract Depot getDepot();

    abstract void setDepot(Depot depot);

}

package ru.smith.ch03.other;

public class ContextualizedDependencyLookup implements ManegedComponent{
    private Dependency dependency;

    @Override
    public String toString() {
        return dependency.toString();
    }

    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }
}

package me.sfriedowitz.molgen.generators;

import java.util.Iterator;

import org.openscience.cdk.interfaces.IAtomContainer;

public interface Generator {
    public Iterator<IAtomContainer> generate();
}

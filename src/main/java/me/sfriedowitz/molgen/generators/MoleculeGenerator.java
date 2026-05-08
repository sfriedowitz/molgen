package me.sfriedowitz.molgen.generators;

import java.util.Iterator;
import me.sfriedowitz.molgen.domain.MolecularStructure;

public interface MoleculeGenerator {
  Iterator<MolecularStructure> generate();
}

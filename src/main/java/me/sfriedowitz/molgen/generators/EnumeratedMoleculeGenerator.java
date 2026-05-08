package me.sfriedowitz.molgen.generators;

import java.util.Iterator;
import java.util.List;
import me.sfriedowitz.molgen.domain.MolecularStructure;

public class EnumeratedMoleculeGenerator implements MoleculeGenerator {

  private List<MolecularStructure> structures;

  public EnumeratedMoleculeGenerator(List<MolecularStructure> structures) {
    this.structures = structures;
  }

  @Override
  public Iterator<MolecularStructure> generate() {
    return structures.iterator();
  }
}

package me.sfriedowitz.molgen.domain;

import me.sfriedowitz.molgen.utils.StructureParser;
import org.openscience.cdk.interfaces.IAtomContainer;

public sealed interface MoleculeEncoding permits MoleculeEncoding.Smiles, MoleculeEncoding.InChI {

  String value();

  default IAtomContainer toContainer() {
    return StructureParser.parse(this);
  }

  record Smiles(String value) implements MoleculeEncoding {}

  record InChI(String value) implements MoleculeEncoding {}
}

package me.sfriedowitz.molgen.utils;

import me.sfriedowitz.molgen.domain.MoleculeEncoding;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;

public class StructureParser {

  private static final SmilesParser smilesParser =
      new SmilesParser(SilentChemObjectBuilder.getInstance());

  public static IAtomContainer parse(MoleculeEncoding structure) {
    return switch (structure) {
      case MoleculeEncoding.Smiles s -> parseSmiles(s.value());
      case MoleculeEncoding.InChI s -> parseInchi(s.value());
    };
  }

  private static IAtomContainer parseSmiles(String smiles) {
    try {
      return smilesParser.parseSmiles(smiles);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid SMILES: " + smiles, e);
    }
  }

  private static IAtomContainer parseInchi(String inchi) {
    throw new UnsupportedOperationException();
  }
}

package me.sfriedowitz.molgen.domain;

import me.sfriedowitz.molgen.utils.StructureConversions;
import org.openscience.cdk.interfaces.IAtomContainer;

public record MolecularStructure(IAtomContainer atomContainer) {

  public static MolecularStructure fromEncoding(MolecularEncoding encoding) {
    return switch (encoding) {
      case MolecularEncoding.Smiles smiles ->
          new MolecularStructure(StructureConversions.smilesToContainer(smiles.value()));
      case MolecularEncoding.Inchi inchi ->
          new MolecularStructure(StructureConversions.inchiToContainer(inchi.value()));
    };
  }

  public MolecularEncoding.Smiles toSmiles() {
    return new MolecularEncoding.Smiles(StructureConversions.containerToSmiles(atomContainer));
  }

  public MolecularEncoding.Inchi toInChI() {
    return new MolecularEncoding.Inchi(StructureConversions.containerToInchi(atomContainer));
  }
}

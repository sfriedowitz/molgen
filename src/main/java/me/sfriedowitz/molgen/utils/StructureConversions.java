package me.sfriedowitz.molgen.utils;

import io.github.dan2097.jnainchi.InchiStatus;
import org.openscience.cdk.inchi.InChIGenerator;
import org.openscience.cdk.inchi.InChIGeneratorFactory;
import org.openscience.cdk.inchi.InChIToStructure;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.smiles.SmilesParser;

public final class StructureConversions {

  private static SmilesParser smilesParser =
      new SmilesParser(SilentChemObjectBuilder.getInstance());

  private static SmilesGenerator smilesGenerator = SmilesGenerator.unique();

  public static IAtomContainer smilesToContainer(String smiles) {
    try {
      return smilesParser.parseSmiles(smiles);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid SMILES: " + smiles, e);
    }
  }

  public static IAtomContainer inchiToContainer(String inchi) {
    try {
      InChIToStructure structure =
          InChIGeneratorFactory.getInstance()
              .getInChIToStructure(inchi, SilentChemObjectBuilder.getInstance());
      InchiStatus status = structure.getStatus();
      if (status == InchiStatus.SUCCESS || status == InchiStatus.WARNING) {
        return structure.getAtomContainer();
      }
      throw new IllegalArgumentException("Invalid InChI: " + inchi + " (" + status + ")");
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid InChI: " + inchi, e);
    }
  }

  public static String containerToSmiles(IAtomContainer container) {
    try {
      return smilesGenerator.create(container);
    } catch (Exception e) {
      throw new IllegalArgumentException("Unable to generate SMILES from container", e);
    }
  }

  public static String containerToInchi(IAtomContainer container) {
    try {
      InChIGenerator generator = InChIGeneratorFactory.getInChIGenerator(container);
      InchiStatus status = generator.getStatus();
      if (status == InchiStatus.SUCCESS || status == InchiStatus.WARNING) {
        return generator.getInchi();
      }
      throw new IllegalArgumentException(
          "Unable to generate InChI from container: " + status + " - " + generator.getMessage());
    } catch (Exception e) {
      throw new IllegalArgumentException("Unable to generate InChI from container", e);
    }
  }
}

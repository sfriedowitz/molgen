package me.sfriedowitz.molgen.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openscience.cdk.interfaces.IAtomContainer;

class StructureConversionsTest {

  @Test
  void convertSmilesToContainer() {
    String smiles = "c1ccccc1";

    IAtomContainer container = StructureConversions.smilesToContainer(smiles);

    assertThat(container).isNotNull();
    assertThat(container.getAtomCount()).isEqualTo(6);
    assertThat(container.getBondCount()).isEqualTo(6);
  }

  @Test
  void convertInchiToContainer() {
    String inchi = "InChI=1S/C6H6/c1-2-4-6-5-3-1/h1-6H";

    IAtomContainer container = StructureConversions.inchiToContainer(inchi);

    assertThat(container).isNotNull();
    assertThat(container.getAtomCount()).isEqualTo(6);
    assertThat(container.getBondCount()).isEqualTo(6);
  }

  @Test
  void convertContainerToSmilesAndInChI() {
    IAtomContainer container = StructureConversions.smilesToContainer("CCO");

    String smiles = StructureConversions.containerToSmiles(container);
    String inchi = StructureConversions.containerToInchi(container);

    assertThat(smiles).isNotBlank();
    assertThat(inchi).startsWith("InChI=");
  }
}

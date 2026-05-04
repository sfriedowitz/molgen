package me.sfriedowitz.molgen.utils;

import static org.assertj.core.api.Assertions.*;

import me.sfriedowitz.molgen.domain.MoleculeEncoding;
import org.junit.jupiter.api.Test;
import org.openscience.cdk.interfaces.IAtomContainer;

class StructureParserTest {

  @Test
  void parseValidSmiles() {
    MoleculeEncoding.Smiles smiles = new MoleculeEncoding.Smiles("c1ccccc1");

    IAtomContainer container = StructureParser.parse(smiles);

    assertThat(container).isNotNull();
    assertThat(container.getAtomCount()).isEqualTo(6);
    assertThat(container.getBondCount()).isEqualTo(6);
  }
}

package me.sfriedowitz.molgen.generators;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import me.sfriedowitz.molgen.domain.MolecularStructure;

/** TODO: Support other traversal modes for combined generators */
public class CombinedMoleculeGenerator implements MoleculeGenerator {
  private List<MoleculeGenerator> generators;

  public CombinedMoleculeGenerator(List<MoleculeGenerator> generators) {
    this.generators = generators;
  }

  @Override
  public Iterator<MolecularStructure> generate() {
    return generators.stream().flatMap(g -> iteratorToStream(g.generate())).iterator();
  }

  private static Stream<MolecularStructure> iteratorToStream(
      Iterator<MolecularStructure> iterator) {
    Spliterator<MolecularStructure> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
    return StreamSupport.stream(spliterator, false);
  }
}

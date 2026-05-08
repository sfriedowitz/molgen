package me.sfriedowitz.molgen.domain;

public sealed interface MolecularEncoding
    permits MolecularEncoding.Smiles, MolecularEncoding.Inchi {

  String value();

  record Smiles(String value) implements MolecularEncoding {}

  record Inchi(String value) implements MolecularEncoding {}
}

package com.ripbull.coreattachment.compressor.image.constraint

class Compression {
  internal val constraints: MutableList<Constraint> = mutableListOf()

  fun constraint(constraint: Constraint) {
    constraints.add(constraint)
  }
}
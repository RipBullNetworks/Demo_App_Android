package com.ripbull.ertc.util.recyclerview

/**
 * @author meeth
 */
interface Diffable<T> {

  fun isSame(t: T): Boolean
  fun isEquals(t: T): Boolean

}
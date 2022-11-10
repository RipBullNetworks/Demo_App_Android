package com.ripbull.ertc.util.recyclerview

/**
 * @author meeth
 */
interface AdapterCallback<T> {

  fun onItemClick(t: T)

  fun onItemLongClick(t: T): Boolean
}
package com.quarkus.bootcamp.nttdata.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de logica de negocio para los productos.
 *
 * @author pdiaz
 */
@Data
@NoArgsConstructor
public class Product {
  protected Long id = null;
  /**
   * Monto registrado al momento de crear el producto
   * 1- Para las cuentas es el monto inicial.
   * 2- Para los creditos es el monto aprobado del credito
   * 3- Para la linea de credito es la disponibilidad maxima de dinero
   */
  protected Double amount;
  /**
   * Id del cliente al que le pertenece el producto
   */
  protected Long customerId;
}

export class Produto {
  id?: number;
  nome?: string;
  descricao?: string;
  descontinuado?: boolean;
  descontinuadoEm?: Date;
  descontinuadoPor?: string;
  descontinuadoObservacao?: string;
  precoVendaUnitario?: number;
  precoCompraUnitario?: number;
  quantidadeDisponivel?: number;
  fornecedor?: string;
}

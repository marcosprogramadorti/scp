import { Uf } from './Uf';
import { TipoDocumento } from './TipoDocumento';

export interface PessoaDocumento {
    idPessoa: number;
    tipoDocumento: TipoDocumento;
    nrDocumento: string;
    dtEmissao: Date;
    nmEmissor: string;
    nrSerie: string;
    uf: Uf;
}
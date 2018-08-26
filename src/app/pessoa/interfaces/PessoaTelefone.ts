import { TipoTelefone } from './TipoTelefone';
export interface PessoaTelefone {
    id: number;
    tipoTelefone: TipoTelefone;
    nrTelefone: number;
    nrDdd: number;
    pessoa:any;
    stPrincipal:any;

}
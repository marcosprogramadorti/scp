import { TipoTelefone } from './../dominios/TipoTelefone';

export class PessoaTelefone {
    id: number;
    tipoTelefone: TipoTelefone;
    nrTelefone: number;
    nrDdd: number;
    pessoa:any;
    stPrincipal:string;
    constructor (){ this.stPrincipal="S"}

}
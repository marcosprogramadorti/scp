import { TipoLogradouro } from './TipoLograduro';
import { Pessoa } from './Pessoa';
import { TipoEndereco } from './TipoEndereco';
import { Localidade } from './Localidade';
export class PessoaEndereco{
    id:number;
    nrCep   :string;
    localidade:Localidade;
    nmBairro:string;
    dsLogradouro:string;
    nrLogradouro:string;
    dsComplemento:string;
    tipoEndereco: TipoEndereco;
    stPrincipal:string;
    pessoa: Pessoa;
    tipoLogradouro:TipoLogradouro;  
    constructor (){ this.stPrincipal="S"}
    
}
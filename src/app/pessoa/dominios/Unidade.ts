import { TipoUnidade } from './TipoUnidade';
export class Unidade{
    id: number;
    tipoUnidade: TipoUnidade;
    tpOrigemUnidade:string;
    unidadeSuperior: Unidade;
    nmUnidade:string;
    sgUnidade:string;
    stAtivo:string;
    dhCadastro:Date;
    dsUnidade:string;
    idUnidadeSuperior:number;
    unidades:Unidade[];    
}


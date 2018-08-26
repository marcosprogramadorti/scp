import { Pais } from './../interfaces/Pais';
import { Pessoa } from './Pessoa';

export class DetalhePessoaFisica{

    stEstrangeiro:number;
    pessoa: Pessoa;
    nacionalidade:Pais;
    tpRegimeCasamento: string;
    stAtivo: string;
    dtChegadaBrasil:Date;
}
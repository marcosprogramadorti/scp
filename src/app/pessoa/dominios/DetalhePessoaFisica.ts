import { ExperienciaProfissional } from './ExperienciaProfissional';
import { Pais } from './../interfaces/Pais';
import { Pessoa } from './Pessoa';

export class DetalhePessoaFisica{

    id:number; /*id pessoa*/
    idPaisNacionalidade:number;
    tpRegimeCasamento:string;
    dtChegadaBrasil:Date;
    dsInformacaoAdicional:string;
    stAtivo:string;
    experienciasProfissionais:ExperienciaProfissional[];
    

}
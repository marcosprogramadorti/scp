import { Localidade } from './Localidade';
import { Pessoa } from './Pessoa';
export class PessoaFisica{
    dtNascimento:Date;
    tpSexo:string;
    pessoa:Pessoa;
    nrCPF:string;
    nmSocial:string;
    nmMae:string;
    stNomeMae:string;
    naturalidade:Localidade;
    tpEstadoCivil:string;
}
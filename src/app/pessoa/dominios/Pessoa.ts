import { PessoaTelefone } from './../interfaces/PessoaTelefone';
import { PessoaJuridica } from './PessoaJuridica';
import { PessoaFisica } from './PessoaFisica';
import { PessoaEndereco } from './PessoaEndereco';
import { PessoaEmail } from './PessoaEmail';
import { PessoaDocumento } from './../interfaces/PessoaDocumento';
import { Unidade } from './Unidade';
import { TipoVinculo } from './TipoVinculo';
export class Pessoa{
    id: number;
    dhCadastro: Date;
    dsInfoAdicional: string;
    nmPessoa: string;
    stAtivo: string
    tpPessoa: string;
    listaTipoVinculos: null;
    tipoVinculo: TipoVinculo;
    unidade: Unidade;
    pessoaDocumentos:PessoaDocumento[];
    pessoaEmails: PessoaEmail[];
    pessoaEnderecos: PessoaEndereco[];
    pessoaTelefones: PessoaTelefone[];
    pessoaFisica: PessoaFisica;
    pessoaJuridica:PessoaJuridica;
    
  }
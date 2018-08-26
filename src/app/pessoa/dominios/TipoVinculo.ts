import { Pessoa } from './Pessoa';
export class TipoVinculo
{
    id: number;
    nmTipoVinculo: string;
    dsTipoVinculo: string;
    stAtivo: string;
    dhCadastro: Date;
    tpPessoa: string;
    pessoas: Pessoa[]
}
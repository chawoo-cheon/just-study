import * as CryptoJS from "crypto-js";

class Block {
    public index    : number;
    public hash     : string;
    public previousHash : string;
    public data     : string;
    public timeStamp: number;
    
    constructor(index:number,hash:string,previousHash:string,data:string,timeStamp:number){
        this.index = index;
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    static calculateBlockHash = (index:number,previousHash:string,timeStamp:number,data:string) : string =>{
        return CryptoJS.SHA256(index+previousHash+timeStamp+data).toString();
    }

    static validateStruture = (aBlock : Block) => typeof aBlock.index === "number"  &&
        typeof aBlock.hash ==="string"  &&
        typeof aBlock.previousHash ==="string"  &&
        typeof aBlock.timeStamp==="number" &&
        typeof aBlock.data ==="string"
}       

const genesisBlock:Block = new Block(0,"12345678","","Hi Thousand",15790000);
let blockchain: Block[] = [genesisBlock];

const getBlockchain = (): Block[] => blockchain;
const getLatestBlock = (): Block => getBlockchain()[blockchain.length - 1];
const getNewTimeStamp = (): number => Math.round(new Date().getTime()/1000);

const createNewBlock = (data:string) => {
    const previousBlock : Block = getLatestBlock();
    const newIndex : number = previousBlock.index + 1;
    const newTimeStamp : number = getNewTimeStamp();
    const newHash : string = Block.calculateBlockHash(newIndex,previousBlock.hash,newTimeStamp,data);
    const newBlock : Block = new Block(newIndex,newHash,previousBlock.hash,data,newTimeStamp);
    addBlock(newBlock);
    return newBlock;
}

const getHashBlock =(aBlock:Block):string => Block.calculateBlockHash(aBlock.index,aBlock.previousHash, aBlock.timeStamp, aBlock.data);

const isBlockValid = (candidateBlock:Block, previousBlock:Block) : boolean => {
    if(!Block.validateStruture(candidateBlock)){
        return false;
    }else if(previousBlock.index+1 !==  candidateBlock.index){
        return false;
    }else if(previousBlock.hash !== candidateBlock.previousHash){
        return false;
    }else if(getHashBlock(candidateBlock) !== candidateBlock.hash){
        return false;
    }else{
        return true; 
    }
}

const addBlock = (candidateBlock:Block):void =>{
     if(isBlockValid(candidateBlock,getLatestBlock())){
        blockchain.push(candidateBlock);
     }
}

createNewBlock("국지예");
createNewBlock("내사랑");
createNewBlock("사랑해요");
createNewBlock("잘준비하나요?");

console.log(blockchain);

export {};

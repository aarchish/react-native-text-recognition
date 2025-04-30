export interface TextBlock {
    text: string;
    frame?: {
      left: number;
      top: number;
      width: number;
      height: number;
    };
    lines?: Array<{
      text: string;
    }>;
  }
  
  export interface TextRecognitionResult {
    text: string;
    blocks: TextBlock[];
  }
  
  export function recognizeText(url: string): Promise<TextRecognitionResult>;
  
  declare const _default: {
    recognizeText: typeof recognizeText;
  };
  
  export default _default;
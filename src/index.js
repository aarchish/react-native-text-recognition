import { NativeModules } from 'react-native';

const { TextRecognitionModule } = NativeModules;

export const recognizeText = async (url) => {
  if (!url) {
    throw new Error('URL is required');
  }

  try {
    const result = await TextRecognitionModule.recognize(url);
    return result;
  } catch (error) {
    console.error('Text recognition error:', error);
    throw error;
  }
};

export default {
  recognizeText,
};
# TextRecognition

🧠 TextRecognition - ML-Powered Text Extraction for React Native
Bring the power of Google's latest ML Kit Text Recognition directly into your React Native app with @jd/react-native-text-recognition. This library allows you to effortlessly detect and extract text from images — printed or handwritten — using cutting-edge machine learning models.

🔥 Note: Due to integration with the newest version of ML Kit, this library requires iOS 16.1+ as the minimum deployment target 
.

Perfect for OCR features, document scanning, form auto-fill, and more! 

✅ Features

🔍 Detects both printed and handwritten text

🚀 Powered by Google ML Kit (v8.0.0+) for high accuracy and performance

📱 Supports iOS 16.1 and above for native capabilities

⚙️ Easy installation via CocoaPods

👌 Works seamlessly with modern React Native projects

📲 Installation

🍎 iOS Setup

This library uses Google ML Kit , so you'll need to update your Podfile accordingly:
## Installation IOS

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pod 'TextRecognition', :path => '../node_modules/@johnsriders/react-native-text-recognition/ios'

pod 'GoogleMLKit/TextRecognition', '~> 8.0.0'
pod 'SDWebImage', '~> 5.11.1'

cd ios && pod install

post_install do |installer|
  installer.pods_project.build_configurations.each do |config|
    config.build_settings["EXCLUDED_ARCHS[sdk=iphonesimulator*]"] = "arm64"
  end
end
```
💡 Make sure your Xcode project is targeting iOS 16.1 or later , as ML Kit now requires it for full functionality 
## Installation Android

```bash
implementation 'com.google.android.gms:play-services-mlkit-text-recognition:19.0.1'
```

## Usage

```javascript

import TextRecognition from '@johnsriders/react-native-text-recognition';

TextRecognition.recognizeFromImage(imagePath)
  .then(text => console.log("Recognized text:", text))
  .catch(err => console.error("Recognition error:", err));
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
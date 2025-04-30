module.exports = {
    dependency: {
      platforms: {
        ios: {
          project: './ios/TextRecognition.xcworkspace',
        },
        android: {
          sourceDir: './android',
          packageImportPath: 'import com.jd.textrecognition.TextRecognitionPackage;',
          packageInstance: 'new TextRecognitionPackage()',
        },
      },
    },
  };
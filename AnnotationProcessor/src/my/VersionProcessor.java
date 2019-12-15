package my;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import java.util.Set;


@SupportedAnnotationTypes({ "my.Version" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class VersionProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement currentAnnotation : annotations) {
			Name qualifiedName = currentAnnotation.getQualifiedName();
			if (qualifiedName.contentEquals("my.Version")) {
				Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(currentAnnotation);
				for (Element element : annotatedElements) {
					Version v = element.getAnnotation(Version.class);
					int major = v.major();
					int minor = v.minor();
					if (major < 0 || minor < 0) {
						String errMsg = "Version cannot be negative. major = " + major + " minor = " + minor;
						Messager messager = this.processingEnv.getMessager();
						messager.printMessage(Diagnostic.Kind.ERROR, errMsg, element);
					}
				}
			}
		}
		return Boolean.TRUE;
	}

}
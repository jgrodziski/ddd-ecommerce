package ddd.ecommerce.domain;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.core.steps.ParameterConverters;

import java.net.URL;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

public abstract class Stories extends JUnitStories {

    private  URL  codeLocation = null;

    protected Stories() {
        codeLocation = CodeLocations.codeLocationFromClass(this.getClass());
        configuredEmbedder().embedderControls()
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInStories(true)
                .doVerboseFailures(true)
                .useThreads(1);

    }

    @Override
    public Configuration configuration() {
        ClassLoader classLoader = this.getClass().getClassLoader();

        Keywords keywords = new LocalizedKeywords(locale());
        Configuration configuration = new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
                .useStoryParser(new RegexStoryParser(keywords))
                .useStoryLoader(new LoadFromClasspath(classLoader))
                //.useStepMonitor(new PrintStreamStepMonitor())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(codeLocation)
                                .withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName())
                                .withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT, Format.HTML)
                                .withFailureTrace(false)
                                .withKeywords(keywords))
                .useParameterConverters(
                        new ParameterConverters()
                                .addConverters(new ParameterConverters.ExamplesTableConverter(new ExamplesTableFactory(keywords))));
        return configuration;
    }

    @Override
    public org.jbehave.core.steps.InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), mySteps());
    }

    @Override
    protected List<String> storyPaths() {
        List<String> storyPaths = new StoryFinder().findPaths(codeLocation.getFile(), asList(storyPattern()), asList(""));
        return storyPaths;
    }

    protected Locale locale() {
        return new Locale("en");
    }

    protected String storyPattern() {
        return "**/*.story";
    }

    protected abstract List<Object> mySteps();


}
